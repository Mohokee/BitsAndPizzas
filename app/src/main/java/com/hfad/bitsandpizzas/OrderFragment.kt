package com.hfad.bitsandpizzas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        // cast the activity to AppCompatActivity to set the toolbar on a fragment
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        //FAB
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        //How to find selected radio button
        fab.setOnClickListener{
            //get radio button group
            val pizzaGroup = view.findViewById<RadioGroup>(R.id.pizza_group)
            //see which radio is checked
            val pizzaType = pizzaGroup.checkedRadioButtonId
            //if all are unchecked, the value is -1
            if(pizzaType == -1){
                //toasts call .make text, then (this/activity,text,and length), then .show to display
                Toast.makeText(activity,"Please Select a Pizza Type",Toast.LENGTH_LONG).show()
            }else{
                val parm = view.findViewById<Chip>(R.id.parm)
                val chili = view.findViewById<Chip>(R.id.chili_oil)
                var text = when(pizzaType){
                    R.id.pizza_diavolo -> "Diavolo pizza"
                    else -> "Funghi pizza"
                }
                text += if(parm.isChecked) ", extra parmesan" else " "
                text += if(chili.isChecked) ", extra chili oil" else " "

                Snackbar.make(fab,"You are ordering a $text",Snackbar.LENGTH_LONG).show()
            }

        }
        // Inflate the layout for this fragment
        return view
    }

}