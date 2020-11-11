package com.mercadolibre.android.andesui.demoapp.feature

import android.content.Context
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.Toast
import com.mercadolibre.android.andesui.button.AndesButton
import com.mercadolibre.android.andesui.datepicker.AndesDatePicker
import com.mercadolibre.android.andesui.demoapp.R
import com.mercadolibre.android.andesui.demoapp.feature.utils.PageIndicator
import com.mercadolibre.android.andesui.textfield.AndesTextfield
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class DatePickerShowcaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.andesui_showcase_main)

        setSupportActionBar(findViewById(R.id.andesui_nav_bar))
        supportActionBar?.title = resources.getString(R.string.andesui_demoapp_screen_datepicker)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewPager = findViewById<ViewPager>(R.id.andesui_viewpager)
        viewPager.adapter = AndesShowcasePagerAdapter(this)
        val indicator = findViewById<PageIndicator>(R.id.page_indicator)
        indicator.attach(viewPager)
    }

    class AndesShowcasePagerAdapter(private val context: Context) : PagerAdapter() {

        var views: List<View>

        init {
            views = initViews()
        }

        override fun instantiateItem(container: ViewGroup, position: Int): View {
            container.addView(views[position])
            return views[position]
        }

        override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
            container.removeView(view as View?)
        }

        override fun isViewFromObject(view: View, other: Any): Boolean {
            return view == other
        }

        override fun getCount(): Int = views.size

        private fun initViews(): List<View> {
            val inflater = LayoutInflater.from(context)

            val staticDatePickerLayout = addStaticDatePicker(inflater)

            return listOf(staticDatePickerLayout)
        }

        private fun addStaticDatePicker(inflater: LayoutInflater): View {
            val layoutDatePicker = inflater.inflate(
                    R.layout.andesui_date_picker_showcase,
                    null,
                    false
            ) as ScrollView

            val datepicker: AndesDatePicker = layoutDatePicker.findViewById(R.id.andesDatePicker)
            val btnSend: AndesButton = layoutDatePicker.findViewById(R.id.btnSendMinMaxDate)
            val btnReset: AndesButton = layoutDatePicker.findViewById(R.id.btnReset)
            val inputMinDate: AndesTextfield = layoutDatePicker.findViewById(R.id.andesTextfieldMinDate)
            val inputMaxDate: AndesTextfield = layoutDatePicker.findViewById(R.id.andesTextfieldMaxDate)
            datepicker.setupBtnVisibility(true)
            datepicker.setupButtonText("Aplicar")

            btnSend.setOnClickListener(){
                datepicker.clearMinMaxDate()
                var setterMax: String? = inputMaxDate.text?.trim()
                var setterMin: String? = inputMinDate.text?.trim()
                if (setterMax != null && isValid(setterMax,"dd/MM/yyyy") && !setterMax.isEmpty()) {
                    datepicker.setupMaxDate(setterMax, "dd/MM/yyyy" )
                }else {
                    Toast.makeText(context, "la fecha maxima no es una fecha valida", Toast.LENGTH_SHORT).show()
                }
                if (setterMin != null && isValid(setterMin, "dd/MM/yyyy") && !setterMin.isEmpty()) {
                    datepicker.setupMinDate(setterMin.toString(),"dd/MM/yyyy" )
                }else {
                    Toast.makeText(context, "la fecha minima no es una fecha valida", Toast.LENGTH_SHORT).show()
                }
            }

            btnReset.setOnClickListener(){
                datepicker.clearMinMaxDate()
            }

            datepicker.setDateListener(object : AndesDatePicker.ApplyDatePickerClickListener {
                override fun onDateApply(date: Calendar) {
                    val dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT)
                    val formattedDate = dateFormatter.format(date.time)
                    Toast.makeText(context, formattedDate, Toast.LENGTH_SHORT).show()
                }})

            return layoutDatePicker

        }

        fun isValid(time:String, format:String): Boolean {
            val df = SimpleDateFormat(format)
            df.isLenient = false
            try {
                df.parse(time)
                return true
            } catch (e: ParseException){
                return false
            }
        }

    }
}
