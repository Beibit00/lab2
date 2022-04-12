package com.example.calculator
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvZero.setOnClickListener{setTextFields("0")}
        tvOne.setOnClickListener{setTextFields("1")}
        tvTwo.setOnClickListener{setTextFields("2")}
        tvThree.setOnClickListener{setTextFields("3")}
        tvFour.setOnClickListener{setTextFields("4")}
        tvFive.setOnClickListener{setTextFields("5")}
        tvSix.setOnClickListener{setTextFields("6")}
        tvSeven.setOnClickListener{setTextFields("7")}
        tvEight.setOnClickListener{setTextFields("8")}
        tvNine.setOnClickListener{setTextFields("9")}
        tvMinus.setOnClickListener{setTextFields("-")}
        tvMulti.setOnClickListener{setTextFields("*")}
        tvPlus.setOnClickListener{setTextFields("+")}
        tvDivide.setOnClickListener{setTextFields("/")}
        tvComma.setOnClickListener { setTextFields("." +
                "") }
        tvClear.setOnClickListener{
            val str=tvExpression.text.toString()
            if(str.isNotEmpty())
                tvExpression.text=str.substring(0,str.length-1)
            tvResult.text=""

        }
        tvEqual.setOnClickListener {
            try {
                val ex=ExpressionBuilder(tvExpression.text.toString()).build()
                val result=ex.evaluate()

                val longRes=result.toLong()
                if(result==longRes.toDouble())
                    tvResult.text=longRes.toString()
                else
                    tvResult.text=result.toString()
            } catch (e:Exception){
                Log.d("Ошибка","сообщение:${e.message}")

            }
        }
    }
    fun setTextFields(str:String){
        if(tvResult.text!="")
            tvExpression.text=tvResult.text
            tvResult.text=""

        tvExpression.append(str)
    }
}