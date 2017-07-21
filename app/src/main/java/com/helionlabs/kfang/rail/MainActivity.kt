package com.helionlabs.kfang.rail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.helionlabs.kfang.rail.api.MbtaRetriever
import com.helionlabs.kfang.rail.models.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.*

class MainActivity : AppCompatActivity() {

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

    fun callApi(v: View) {
        Log.d("MainActivity", todaysEpoch().toString())
        val retriever = MbtaRetriever()
        disposable = retriever.getInboundCommuterSchedule("CR-Providence", todaysEpoch())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                        onNext = { response: Response ->
                            Log.d("MainActivity", response.toString())
                        },
                        onComplete = {
                            Toast.makeText(this, "Call Complete", Toast.LENGTH_SHORT).show()
                        },
                        onError = { t: Throwable ->
                            Log.e("MainActivity", "Error:", t)
                        }
                )
    }
}
