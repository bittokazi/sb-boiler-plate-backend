package com.backend.boiler.plate.modules.base.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExecutorService {
	private final Logger logger = LoggerFactory.getLogger(ExecutorService.class);
	
	public void run(Executor executor, String errorMessage) {
		try {
			executor.execute();
		} catch(Exception e) {
			logger.error(errorMessage, e);
		}
	}
}

