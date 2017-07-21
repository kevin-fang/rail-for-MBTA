package com.helionlabs.kfang.rail

import android.content.Intent
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
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        query_api.setOnClickListener {
            launchTrainDetail()
        }
    }

    private fun launchTrainDetail() {
        val intent = Intent(this, TrainDetailActivity::class.java)
        intent.putExtra(TrainDetailActivity.TRAIN_NAME, "CR-Providence")
        intent.putExtra(TrainDetailActivity.TRAIN_BOUND, MbtaRetriever.INBOUND)
        startActivity(intent)
    }

}
