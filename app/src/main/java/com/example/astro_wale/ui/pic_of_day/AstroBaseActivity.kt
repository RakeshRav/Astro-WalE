package com.example.astro_wale.ui.pic_of_day

import androidx.appcompat.app.AppCompatActivity

open class AstroBaseActivity: AppCompatActivity() {

    //creating parent class, as base activity this will help in placing common code
    //throughout the application which will be needed by the child activity
    //for example if we need error view, or error view model
    //we can directly create a veiw model and provide the same to the chhild activity with
    //customised view and data for the error then activity can place that view model accordingly
    //leaving this blanc for now
}