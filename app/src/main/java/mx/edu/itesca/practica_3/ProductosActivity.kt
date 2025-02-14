package mx.edu.itesca.practica_3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductosActivity : AppCompatActivity() {

    var menu:ArrayList<Product> = ArrayList<Product>()

    lateinit var imagen: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imagen = findViewById(R.id.imageView)

        var menuOption: String? = intent.getStringExtra("menuType")

        agregarProductos(menuOption)

        var listview: ListView = findViewById(R.id.litview) as ListView
        var adaptador: AdaptadorProductos = AdaptadorProductos(this,menu)
        listview.adapter = adaptador


    }


    fun agregarProductos (option:String?) {
        when (option){
            "Antojitos"->{
                imagen.setImageResource(R.drawable.antojitos)
                menu.add(Product("Quesadillas", R.drawable.quesadillas,"Rellenas con su carne favorita, servidas con ensalada. Filled with your choice of meat, served with salad.",5.99))
                menu.add(Product("Huaraches", R.drawable.huaraches,"Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema. Big Thick tortilla with beans, your choice of meat, fresh cheese, and sour cream." ,10.99))
                menu.add(Product("Gringas", R.drawable.gringas,"Tortilla de harina con queso, carne al pastor y piña Flour tortilla with cheese marinated pork and pineapple.",7.99))
                menu.add(Product("Sincronizadas", R.drawable.sincronizadas,"Tortilla de harina rellena con queso y jamon. Se sirve con lechuga, crema y guacamole Sandwich of Two four tortillas filled with ham and cheese. Served with lettuce, sour cream, and guacamole.",7.99))
                menu.add(Product("Sopes", R.drawable.sopes,"Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema Fried thick tortilla with beans, your choice of meat, lettuce, fresh cheese, and sour cream." ,3.79))
                menu.add(Product ("Tostadas", R.drawable.tostadas,"Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate Fried tortilla with beans, your choice of meat, lettuce, fresh cheese, sour cream and tomatoes.",4.59))
                menu.add(Product ("Coctel mixto", R.drawable.coctel,"No tiene descripción                .",21.99))
            }
            "Especialidades"->{
                imagen.setImageResource(R.drawable.especialidades)

            }
            "Combos"->{
                imagen.setImageResource(R.drawable.combinations)

            }
            "Tortas"->{
                imagen.setImageResource(R.drawable.tortas)
                menu.add(Product("Torta Regular", R.drawable.torta,
                    "Todas las tortas vienen con lechuga, cebolla, jitomate, aguacate, crema, jalapeño y tu elección de carne. All tortas come with lettuce, onions, tomatoes, avocado, sour cream, jalapeño pepper and your choice of meat.", 12.99))

                menu.add(Product("Torta - Milanesa de Res o Pollo", R.drawable.tortamilanesa,
                    "Milanesa de res o de pollo. Breaded steak or chicken.", 13.99))

                menu.add(Product("Torta Cubana", R.drawable.tortacubana,
                    "Chorizo, asada, jamón, pastor y queso. Mexican sausage, steak, marinated pork, ham, and cheese.", 13.99))

                menu.add(Product("Torta Mixta", R.drawable.tortamixta,
                    "Chorizo, asada y pastor. Mexican sausage, steak and marinated pork.", 13.99))

                menu.add(Product("Small Mexican Torta", R.drawable.smallmexican,
                    "Bolillo con tu elección de carne, lechuga, jitomate, cebolla, aguacate y crema. Bolillo bread sandwich with your choice of meat, shredded lettuce, avocado, tomato, onion and sour cream.", 7.39))
            }

            "Sopas"->{
                imagen.setImageResource(R.drawable.sopas)
                menu.add(Product("Pozole", R.drawable.pozole,
                    "Solo fines de semana. Weekends only.", 5.99))

                menu.add(Product("Menudo", R.drawable.menudo,
                    "Disponible de miércoles a domingo. Wednesday to Sunday.", 5.99))

                menu.add(Product("Caldo de Res", R.drawable.caldores,
                    "No tiene descripción                .", 5.99))

                menu.add(Product("Caldo de Camarón", R.drawable.caldocamaron,
                    "Sopa de camarón. Shrimp soup.", 13.99))

                menu.add(Product("Sopa de Mariscos", R.drawable.sopamariscos,
                    "Sopa de mariscos. Seafood soup.", 19.99))
            }

            "Drinks"->{
                imagen.setImageResource(R.drawable.drinks)
                menu.add(Product("Soft Drinks 20oz", R.drawable.sodas,
                    "Sodas 20oz.", 2.99));

                menu.add(Product("Jarritos", R.drawable.jarritos,
                    "", 2.75));

                menu.add(Product("Aguas Frescas", R.drawable.drinks,
                    "", 2.99));
            }




        }
    }

    private class AdaptadorProductos:BaseAdapter{
        var productos = ArrayList<Product>()
        var contexto: Context?=null

        constructor(contexto:Context,productos:ArrayList<Product>){
            this.productos=productos
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            var prod=productos[p0]
            var inflador= LayoutInflater.from(contexto)
            var vista=inflador.inflate(R.layout.producto_view,null)

            var imagen=vista.findViewById(R.id.producto_img) as ImageView
            var nombre=vista.findViewById(R.id.producto_nombre) as TextView
            var desc=vista.findViewById(R.id.producto_desc) as TextView
            var precio=vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")
            return vista
        }
    }

}