package activities

import activities.SimulationConfig.httpProtocol
import activities.SimulationConfig.simulationTimeSec
import activities.SimulationConfig.usersCount
import io.gatling.javaapi.core.CoreDsl.constantUsersPerSec
import io.gatling.javaapi.core.CoreDsl.scenario
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http

class NonIndexedActivitiesSimulation : Simulation() {
    init {
        setUp(
            scenario("Non Indexed Activities").exec(
                http("Non Indexed activities")
                    .get("/activities/non-indexed?groupNumber=1234")
            ).injectOpen(constantUsersPerSec(usersCount).during(simulationTimeSec)),
        ).protocols(httpProtocol)
    }
}
