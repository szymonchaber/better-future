package guide.betterfuture.core.domain.executor

import io.reactivex.Scheduler

interface PostExecutionThread {

    val scheduler: Scheduler
}
