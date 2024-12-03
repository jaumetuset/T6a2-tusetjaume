package com.actividad.t6a2_tusetjaume.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.actividad.t6a2_tusetjaume.Fragments.AccountsFragment
import com.actividad.t6a2_tusetjaume.R
import com.actividad.t6a2_tusetjaume.databinding.ActivityGlobalPositionBinding
import com.actividad.t6a2_tusetjaume.pojos.Cliente

class GlobalPositionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGlobalPositionBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_global_position)
        super.onCreate(savedInstanceState)

            binding = ActivityGlobalPositionBinding.inflate(layoutInflater)
            setContentView(binding.root)

            //Recuperar el cliente
            val clienteLogeado = intent.getSerializableExtra("Cliente")

            //Creamos la instancia del fragment
            val frgAccounts: AccountsFragment =
                AccountsFragment.newInstance(clienteLogeado as Cliente)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}