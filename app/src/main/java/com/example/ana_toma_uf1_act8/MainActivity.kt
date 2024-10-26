package com.example.ana_toma_uf1_act8

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkBoxDesignUI = findViewById<CheckBox>(R.id.checkBoxDesignUI)
        val checkBoxPSP = findViewById<CheckBox>(R.id.checkBoxPSP)
        val checkBoxDesign2D3D = findViewById<CheckBox>(R.id.checkBoxDesign2D3D)
        val checkBoxMobileDevices = findViewById<CheckBox>(R.id.checkBoxMobileDevices)
        val radioGroupTurn = findViewById<RadioGroup>(R.id.radioGroupTurn)
        val buttonEnroll = findViewById<Button>(R.id.buttonEnroll)

        buttonEnroll.setOnClickListener {
            // Obtener materias
            val subjects = StringBuilder("Matèries seleccionades: ")
            if (checkBoxDesignUI.isChecked) subjects.append("Disseny d'interfície ")
            if (checkBoxPSP.isChecked) subjects.append("PSP ")
            if (checkBoxDesign2D3D.isChecked) subjects.append("Disseny 2D/3D ")
            if (checkBoxMobileDevices.isChecked) subjects.append("Dispositius Mòbils ")

            // Obtener turno 
            val selectedTurnId = radioGroupTurn.checkedRadioButtonId
            val turn = when (selectedTurnId) {
                R.id.radioButtonMorning -> "Torn: Matí"
                R.id.radioButtonAfternoon -> "Torn: Tarda"
                else -> ""
            }

            // Mostrar en Toast
            Toast.makeText(this, "$subjects\n$turn", Toast.LENGTH_LONG).show()
        }
    }
}
