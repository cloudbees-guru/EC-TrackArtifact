import com.cloudbees.flowpdf.*
import com.electriccloud.client.groovy.ElectricFlow
import com.electriccloud.client.groovy.models.ActualParameter

/**
* TrackArtifact
*/
class TrackArtifact extends FlowPlugin {

    @Override
    Map<String, Object> pluginInfo() {
        return [
                pluginName     : '@PLUGIN_KEY@',
                pluginVersion  : '@PLUGIN_VERSION@',
                configFields   : ['config'],
                configLocations: ['ec_plugin_cfgs'],
                defaultConfigValues: [:]
        ]
    }
/** This is a special method for checking connection during configuration creation
    */
    def checkConnection(StepParameters p, StepResult sr) {
        // Use this pre-defined method to check connection parameters
        try {
            // Put some checks here
            def config = context.configValues
            log.info(config)
            // Getting parameters:
            // log.info config.asMap.get('config')
            // log.info config.asMap.get('desc')
            // log.info config.asMap.get('endpoint')
            // log.info config.asMap.get('credential')
            
            // assert config.getRequiredCredential("credential").secretValue == "secret"
        }  catch (Throwable e) {
            // Set this property to show the error in the UI
            sr.setOutcomeProperty("/myJob/configError", e.message + System.lineSeparator() + "Please change the code of checkConnection method to incorporate your own connection checking logic")
            sr.apply()
            throw e
        }
    }
// === check connection ends ===

/**
    * trackArtifact - Track Artifact/Track Artifact
    * Add your code into this method and it will be called when the step runs
    
    */
    def trackArtifact(StepParameters p, StepResult sr) {
        // Use this parameters wrapper for convenient access to your parameters
        TrackArtifactParameters sp = TrackArtifactParameters.initParameters(p)

        ElectricFlow ec = new ElectricFlow()
        def response = ec.evalDsl(dsl: 'artifact artifactKey: "$[/myComponent/ec_content_details/artifactName]", groupId: "group"')

        sr.apply()
    }

// === step ends ===

}