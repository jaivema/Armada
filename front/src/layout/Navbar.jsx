import {Link} from "react-router-dom"
import "./navbar.css"

export default function Navbar(){
    return(
        <>
        <header>
            <div id="logo">
                 <img src="src/assets/LOGO_ARMADA_324x205.png" alt="Armada Cider 1588"/>
            </div>
            <nav>
                <div id="navItems">
                    <Link to="/">Inicio</Link>
                    <Link to="/History">Historia</Link>
                    <Link to="/Shop">Tienda</Link>
                </div>
            </nav>
        </header>
        </>
    )
}