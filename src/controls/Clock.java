package controls;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

import application.interfaces.TickEventHandler;

public class Clock extends Label {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private String currentTime = "";
	private Thread backgroundThread;
	private Thread displayThread;
    private volatile boolean keepCounting;
    private TickEventHandler tickEventHandler;

    public Clock() {
    	super();
        startClock();
    }

    private void updateCurrentTime() {
        currentTime = dateFormat.format(new Date());
    }

    private void displayCurrentTime() {
    	Platform.runLater(() -> {
            setText(currentTime);
            if (tickEventHandler != null) {
                tickEventHandler.handle();
            }
        });
    }
    
    public boolean isRunning() {
    	return this.keepCounting;
    }
    
    public void stopClock() {
    	this.keepCounting = false;
    	Platform.runLater(() -> setText(currentTime + " - STOPPED"));
    }
    
    public void startClock() {
    	this.keepCounting = true;

        backgroundThread = new Thread(() -> {
            while (keepCounting) {
                try {
                	updateCurrentTime();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        backgroundThread.setPriority(Thread.NORM_PRIORITY - 1);


        displayThread = new Thread(() -> {
            while (keepCounting) {
                displayCurrentTime();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        displayThread.setPriority(Thread.NORM_PRIORITY - 1);
        
        backgroundThread.start();
        displayThread.start();
    }
    
    public void onTick(TickEventHandler handler) {
        this.tickEventHandler = handler;
    }
}