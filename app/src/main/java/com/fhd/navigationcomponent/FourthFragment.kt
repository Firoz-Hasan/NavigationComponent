package com.fhd.navigationcomponent


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_fourth.*
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class FourthFragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController
    lateinit var recipient: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view?.findViewById<Button>(R.id.send_btn)?.setOnClickListener(this)
        view?.findViewById<Button>(R.id.cancel_btn)?.setOnClickListener(this)
        val message = "Sending money to $recipient"
        view?.findViewById<TextView>(R.id.recipient)?.text = message

    }

    override fun onClick(p0: View?) {

        when (p0!!.id) {
            R.id.send_btn -> {
                if (!TextUtils.isEmpty(input_amount.text.toString())) {

                    val amount = Money(BigDecimal(input_amount.text.toString()))
                   //val amount = input_amount.text.toString()
                    val bundle = bundleOf(
                        "recipient" to recipient,
                        "amount" to amount
                    )
                    navController!!.navigate(
                        R.id.action_fourthFragment_to_fifthFragment,
                        bundle
                    )
                } else {
                    Toast.makeText(activity, "Enter an amount", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.cancel_btn -> activity!!.onBackPressed()

        }
    }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_fourth, container, false)
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            recipient = arguments?.getString("recipient").toString()

        }
    }

