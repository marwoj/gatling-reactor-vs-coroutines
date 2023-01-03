package activities

import activities.SimulationConfig.httpProtocol
import activities.SimulationConfig.simulationTimeSec
import activities.SimulationConfig.usersCount
import io.gatling.javaapi.core.CoreDsl.constantUsersPerSec
import io.gatling.javaapi.core.CoreDsl.scenario
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http

class IndexedActivitiesSimulation : Simulation() {
    init {
        setUp(
            scenario("Indexed Activities").exec(
                http("Indexed activities")
                    .get("/activities/indexed?groupNumber=123")
            ).injectOpen(constantUsersPerSec(usersCount).during(simulationTimeSec)),
        ).protocols(httpProtocol)
    }
}
