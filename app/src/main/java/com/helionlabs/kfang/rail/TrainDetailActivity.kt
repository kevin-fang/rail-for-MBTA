package com.helionlabs.kfang.rail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.helionlabs.kfang.rail.api.MbtaRetriever
import com.helionlabs.kfang.rail.models.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.*

/**
 * Detail activity for train
 */

class TrainDetailActivity : AppCompatActivity() {

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.train_detail_activity)
        val train_name = intent.extras.getString(TRAIN_NAME)
        val train_bound = intent.extras.getInt(TRAIN_BOUND)
        callApi(train_name, train_bound)
    }

    fun todaysEpoch(): Long {
        val c = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        c.set(Calendar.HOUR_OF_DAY, 0)
        c.set(Calendar.MINUTE, 0)
        c.set(Calendar.SECOND, 0)
        c.set(Calendar.MILLISECOND, 0)
        val unixTimeStamp = c.timeInMillis / 1000
        return unixTimeStamp
    }

    fun callApi(train_name: String, train_bound: Int) {
        Log.d("MainActivity", todaysEpoch().toString())
        val retriever = MbtaRetriever()
        disposable = retriever.getBoundedCommuterSchedule(train_name, todaysEpoch(), train_bound)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                        onNext = { response: Response ->
                            Log.d("TrainDetailActivity", response.toString())
                        },
                        onComplete = {
                            Toast.makeText(this, "Call Complete", Toast.LENGTH_SHORT).show()
                        },
                        onError = { t: Throwable ->
                            Log.e("TrainDetailActivity", "Error:", t)
                        }
                )
    }

    companion object {
        val TRAIN_NAME = "train.name"
        val TRAIN_BOUND = "train.bound"
    }
}