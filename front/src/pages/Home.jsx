import Navbar from "../layout/Navbar";
import Footer from "../layout/Footer";
//-------------------imagenes
import barriles from "../assets/Barriles_S-1024x577-1024x577.png"
import prensa from "../assets/Prensa_S-1.png"
import medalla from "../assets/40d6c3a1-node_ICC_2023_Bronze_Medium.png"
import strawberryBottle from "../assets/StrawberryBottle_S-260x400.png"
import currantBottle from "../assets/BlackCurrantBottle_S-260x400.png"
import appleBottle from "../assets/AppleBottle_S-260x400.png"
import appleGlass from "../assets/AppleGlass_S.png"
import currantGlass from "../assets/BlackCurrantGlass_S.png"
import strawberryGlass from "../assets/WildStrawberryGlass_S-1.png"
import sugar from "../assets/Sugar.png"
import gluten from "../assets/Gluten.png"
import vegan from "../assets/Vegan.png"
import eek from "../assets/Kosher-new.png"
//---------------------------

import './home.css'

export default function Home (){
    return (
        <>
        <header>
            <Navbar />
        </header>

        <section id="home">
            <article className="premium">
                <p>WE WON THIS YEAR! &gt;&gt;&gt;</p>
                <img src={medalla}/>
            </article>
        </section>
        
        <section id="history-banner">
            <img src={barriles}/>
            <p>NUESTRA HISTORIA ARMADA CIDER 1588</p>
            <img src={prensa}/>
        </section>
        
        <section id="products">
            <h1>NUESTRAS SIDRAS</h1>
            <article className="product">
                <img className="bottle" src={appleBottle} alt="Apple flavour"/>
                <img className="glass" src={appleGlass}/>
                <h3>{'"CRAFT APPLE"'}</h3>
                <p>La sidra de manzana se reduce a continuación hasta 4,5% alc./vol (de aproximadamente 9% alc./vol) utilizando el jugo de manzanas prensadas y agua natural de un pozo de alta calidad con bajo contenido en sodio y alto contenido mineral.</p>
            </article>
            <article className="product">
                <img className="bottle" src={currantBottle} alt="Black currant flavour"/>
                <img className="glass" src={currantGlass}/>
                <h3>{'"GROSELLAS NEGRAS Y FRESAS SILVESTRES"'}</h3>
                <p>Sidra de manzana con aromas naturales de grosellas negras y fresas silvestres. Contiene sólo un 3% azúcares añadidos! Sólo 12 g por botella de 400 ml!</p>
            </article>
            <article className="product">
                <img className="bottle" src={strawberryBottle} alt="Strawberry flavour"/>
                <img className="glass" src={strawberryGlass} />
                <h3>{'"FRESAS SILVESTRES"'}</h3>
                <p>Sidra de manzana y aromas naturales de fresas silvestres.También contiene sólo un 3% azúcares añadidos! Sólo 12 g por botella de 400 ml!</p>
            </article>
            <button>Ver tienda</button>
        </section>
        <section id="features">
            <h1>POR QUÉ ARMADA CIDER 1588</h1>
            <h2>ESTAMOS CONCIENCIADOS CON LOS PRODUCTOS MÁS SALUDABLES</h2>
            <article className="columns">
                <div className="column1">
                    <img src={gluten}/>
                    <p>¡SIN GLUTEN!</p>
                </div>
                <div className="column2">
                    <img src={sugar}/>
                    <p>¡0% de azúcar añadido para la variante de manzana (craft apple) y sólo el 3% para las variantes con otras frutas!</p>
                </div>
                <div className="column3">
                    <img src={vegan}/>
                    <p>¡La sidra de manzana (SKU craft apple) está elaborada con vino de manzana fermentado y jugo de manzana prensada añadido, conjuntamente al 85% en volumen del líquido terminado!</p>
                </div>
                <div className="column4">
                    <img src={eek}/>
                    <p>Kosher. ¡Sidras más refrescantes, más sabrosas y más saludables!</p>
                </div>
            </article>
            <p>Elaborada con ingredientes de calidad superior</p>
        </section>
        <section id="dealers">
            <h1>NUESTROS DISTRIBUIDORES</h1>
        </section>
        <footer>
            <Footer />
        </footer>
        </>
    )
}