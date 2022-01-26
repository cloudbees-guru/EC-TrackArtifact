$[/myProject/groovy/scripts/preamble.groovy.ignore]

TrackArtifact plugin = new TrackArtifact()
plugin.runStep('$[/myProcedure/name]', 'checkConnection', 'checkConnection')