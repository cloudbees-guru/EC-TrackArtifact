
// DO NOT EDIT THIS BLOCK BELOW=== Parameters starts ===
// PLEASE DO NOT EDIT THIS FILE

import com.cloudbees.flowpdf.StepParameters

class TrackArtifactParameters {
    /**
    * Label: Group ID, type: entry
    */
    String groupId

    static TrackArtifactParameters initParameters(StepParameters sp) {
        TrackArtifactParameters parameters = new TrackArtifactParameters()

        def groupId = sp.getParameter('groupId').value
        parameters.groupId = groupId

        return parameters
    }
}
// DO NOT EDIT THIS BLOCK ABOVE ^^^=== Parameters ends, checksum: 0e59e19d0c0322e489ec6d545d6c2006 ===
