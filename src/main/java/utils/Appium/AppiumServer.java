package utils.Appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utils.logger.LogController;

import java.io.File;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

public class AppiumServer {
    protected static final LogController LOGGER =  new LogController(MethodHandles.lookup().lookupClass());
    private AppiumDriverLocalService service;
    private  AppiumConfig appiumConfig;// = env.getAppiumConfig();
    //private String appiumUrl = String.format("%s:%d", env.getAppiumConfig().getHubURL(),env.getAppiumConfig().getUsingPort());

    //Inicia el servidor de appium
    public void serverStart() {

        // Copia las variables de entorno actuales y agrega las nuevas
        Map<String, String> systemEnv = new HashMap<>(System.getenv());
        // Define la ruta de tu SDK de Android
        String androidSdkPath = appiumConfig.getAndroidHome();
        String pathSeparator = appiumConfig.getPathSeparator();
        systemEnv.put("ANDROID_HOME", androidSdkPath);
        systemEnv.put("ANDROID_SDK_ROOT", androidSdkPath);
        systemEnv.put("PATH",String.format("%s%s%s/cmdline-tools/latest/bin%s%s/platform-tools",systemEnv.get("PATH"), pathSeparator,androidSdkPath, pathSeparator,androidSdkPath));

        LOGGER.info("Construye e inicia el servidor de Appium");
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .usingPort(appiumConfig.getUsingPort())
                .withIPAddress(appiumConfig.getAppiumServer())
                .withEnvironment(systemEnv)
                .withAppiumJS(new File(appiumConfig.getAppiumJsPath()))
                .usingDriverExecutable(new File(appiumConfig.getExecutablePath()))
                .withLogFile(new File(appiumConfig.getLogFileName()))
                .withArgument(GeneralServerFlag.LOG_LEVEL, appiumConfig.getLogLevel());

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        if(appiumConfig.getAppiumLogs()) {
            service.clearOutPutStreams();
        }
    }

    public String appiumUrl() {
       return "";//appiumUrl;
    }
}
