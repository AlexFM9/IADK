// CArtAgO artifact of counter (EnvironmentApplication). Generated once by the IDK:
// write here the code of its operations. The "AppLinker (AgentSpeak)" and
// "Code synchronizer (AgentSpeak)" modules update the model from this class
// (its @OPERATION methods and the properties it defines with defineObsProperty).
package tools;

import cartago.*;

public class Counter extends Artifact {

    void init() {
        defineObsProperty("count", 0);
    }

    @OPERATION
    void inc() {
        ObsProperty count = getObsProperty("count");
        count.updateValue(count.intValue() + 1);
    }

    @OPERATION
    void turno(OpFeedbackParam<Integer> n) {

        ObsProperty p = getObsProperty("count");

        p.updateValue(p.intValue() + 1);

        n.set(p.intValue());

    }
}
