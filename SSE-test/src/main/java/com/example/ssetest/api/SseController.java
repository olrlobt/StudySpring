package com.example.ssetest.api;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class SseController {
	private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();
	private final ExecutorService executor = Executors.newCachedThreadPool();

	// 클라이언트가 연결을 요청하는 API
	@GetMapping("/connect")
	public SseEmitter connect(@RequestParam(required = false, defaultValue = "defaultId") String clientId) {
		SseEmitter emitter = new SseEmitter(Long.MAX_VALUE); // Long.MAX_VALUE로 타임아웃을 최대화
		this.emitters.put(clientId, emitter);

		emitter.onCompletion(() -> this.emitters.remove(clientId));
		emitter.onTimeout(() -> this.emitters.remove(clientId));
		emitter.onError((e) -> this.emitters.remove(clientId));

		return emitter;
	}

	// 외부에서 이벤트를 발송하는 API
	@PostMapping("/send-event")
	public String sendEvent(@RequestParam String message) {
		for (Map.Entry<String, SseEmitter> entry : emitters.entrySet()) {
			SseEmitter emitter = entry.getValue();
			try {
				emitter.send(SseEmitter.event().data(message));
			} catch (IOException e) {
				emitter.completeWithError(e);
				return "Error sending event";
			}
		}
		return "Event sent";
	}
}