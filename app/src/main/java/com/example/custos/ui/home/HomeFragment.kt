package com.example.custos.ui.home

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.custos.R
import com.example.custos.R.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(layout.fragment_home, container, false)

        val armButton: Button = root.findViewById(R.id.buttonARM)
        val lockIcon: ImageView = root.findViewById(R.id.lockIcon)

        armButton.setOnClickListener {
            if ( armButton.text == "DISARM"){
                armButton.text = "ARM"
                lockIcon.setImageDrawable(
                    ContextCompat.getDrawable(
                        getActivity()!!.getApplicationContext(),
                        R.drawable.ic_unlock))
            }else{
                armButton.text = "DISARM"
                lockIcon.setImageDrawable(
                    ContextCompat.getDrawable(
                        getActivity()!!.getApplicationContext(),
                        R.drawable.ic_lock))
            }
        }


        return root
    }
}
