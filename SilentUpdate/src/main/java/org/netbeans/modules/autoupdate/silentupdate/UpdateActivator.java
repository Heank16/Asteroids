package org.netbeans.modules.autoupdate.silentupdate;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.openide.modules.ModuleInstall;

/**
 * Manages a module's lifecycle. Remember that an installer is optional and
 * often not needed at all.
 */
@SuppressWarnings("unused")
public class UpdateActivator extends ModuleInstall {

    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    @Override
    public void restored() {
        executor.scheduleAtFixedRate(doCheck, 2000, 5000, TimeUnit.MILLISECONDS);
    }

    private static final Runnable doCheck = UpdateHandler::checkAndHandleUpdates;
}
