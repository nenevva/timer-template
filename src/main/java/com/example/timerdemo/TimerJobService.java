package com.example.timerdemo;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.logging.Logger;

public class TimerJob {
	static long count = 0;

	Logger logger = Logger.getLogger("TimeJob");

	TimerTask timerTask = new TimerTask() {
		@Override
		public void run() {
			count++;
			logger.log(count);
		}
	};
	public void job() {

		ThreadFactory tf = new ThreadFactoryBuilder().setNameFormat("tjob-%d").build();

		ScheduledExecutorService ses = new ScheduledThreadPoolExecutor(3);

		ses.scheduleAtFixedRate(timerTask, 0, 1000, TimeUnit.MILLISECONDS);
	}
}
