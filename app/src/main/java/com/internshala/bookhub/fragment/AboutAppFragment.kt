package com.internshala.bookhub.fragment


import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.internshala.bookhub.R
import com.internshala.bookhub.activity.DatabaseHelper
import kotlinx.android.synthetic.main.fragment_about_app.*

/**
 * A simple [Fragment] subclass.
 */
class AboutAppFragment : Fragment() {
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var mobileTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=  inflater.inflate(R.layout.fragment_about_app, container, false)
        return view






    }


}
