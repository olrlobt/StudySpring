package com.example.ssetest.api;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class SseController {

	private final ExecutorService executor = Executors.newCachedThreadPool();

	@GetMapping("/stream-sse")
	public SseEmitter streamEvents() {
		SseEmitter emitter = new SseEmitter();
		executor.execute(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					Thread.sleep(1000); // 1 second
					emitter.send(SseEmitter.event().data("Event #" + i));
				}
				emitter.complete();
			} catch (InterruptedException | IOException e) {
				emitter.completeWithError(e);
			}
		});
		return emitter;
	}
}