package com.gardner.honorsmobileapps.coffeeorderlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

var quantity =  1
lateinit var amount: TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        amount = findViewById(R.id.num_products)

        val buttonSummary: Button = findViewById(R.id.calculate)
        buttonSummary.setOnClickListener {view -> submitOrder()}
        val minusButton: Button = findViewById(R.id.minus)

        minusButton.setOnClickListener { view -> updateQuantity(-1) }
        val plusButton: Button = findViewById(R.id.plus)
        plusButton.setOnClickListener { view -> updateQuantity(1) }


    }

    fun updateQuantity(num: Int) {
     //   val textSummary: TextView = findViewById(R.id.price)

        if (quantity + num < 1) {
            Toast.makeText(this, "You can't order less than 1 cup.", Toast.LENGTH_LONG).show()
        } else if (quantity + num > 10) {
            Toast.makeText(this, "You can't order more than 10 cups.", Toast.LENGTH_LONG).show()
        } else {
            quantity = quantity + num
        }
        amount.text = quantity.toString()
    }
    fun submitOrder(){
        val name: EditText = findViewById(R.id.edit1)
        val whip: CheckBox = findViewById(R.id.check1)
        val chocolate: CheckBox = findViewById(R.id.check2)
        val order: TextView = findViewById(R.id.price)
        var receipt: String = "Thanks ${name.text}! \n${quantity} coffees"
        if(quantity == 1){
            receipt = "Thanks ${name.text}! \n${quantity} coffee"
        }
        var totalPrice = quantity*5
        if(whip.isChecked()){
            receipt = receipt + "\n+ Whipped Cream"
            totalPrice =totalPrice + quantity
        }
        if(chocolate.isChecked()){
            receipt = receipt + "\n+ Chocolate"
            totalPrice =totalPrice + quantity*2
        }
        receipt = receipt + "\nTotal: $${totalPrice}.00"
        order.text = receipt
    }
}