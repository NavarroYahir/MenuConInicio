package mx.edu.itesca.practica_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnAntojitos:Button = findViewById(R.id.btnAntojitos) as Button
        var btnEspecialidades:Button= findViewById(R.id.btnEspecialidades) as Button
        var btnCombinaciones:Button= findViewById(R.id.btnCombinaciones) as Button
        var btnTortas:Button= findViewById(R.id.btnTortas) as Button
        var btnSopas:Button= findViewById(R.id.btnSopas) as Button
        var btnDrinks:Button= findViewById(R.id.btnDrinks) as Button

        btnAntojitos.setOnClickListener{
            var intent: Intent = Intent(this,ProductosActivity::class.java)
            intent.putExtra("menuType","Antojitos")
            startActivity(intent)
        }

        btnEspecialidades.setOnClickListener{
            var intent: Intent = Intent(this,ProductosActivity::class.java)
            intent.putExtra("menuType","Especialidades")
            startActivity(intent)
        }

        btnCombinaciones.setOnClickListener{
            var intent: Intent = Intent(this,ProductosActivity::class.java)
            intent.putExtra("menuType","Combinaciones")
            startActivity(intent)
        }

        btnTortas.setOnClickListener{
            var intent: Intent = Intent(this,ProductosActivity::class.java)
            intent.putExtra("menuType","Tortas")
            startActivity(intent)
        }

        btnSopas.setOnClickListener{
            var intent: Intent = Intent(this,ProductosActivity::class.java)
            intent.putExtra("menuType","Sopas")
            startActivity(intent)
        }

        btnDrinks.setOnClickListener{
            var intent: Intent = Intent(this,ProductosActivity::class.java)
            intent.putExtra("menuType","Drinks")
            startActivity(intent)
        }

    }
}