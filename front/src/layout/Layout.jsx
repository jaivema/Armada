import Footer from './Footer.jsx'
import About from '../pages/About.jsx'
import History from '../pages/History.jsx'
import Shop from '../pages/Shop.jsx'
import {Outlet, Link} from "react-router-dom"

export default function Layout (){
    return (
        <>
        <nav>
            <Link to ="/">
                <img id="logo" src="src/assets/LOGO_ARMADA_324x205.png"></img>             
            </Link>
            <div>
                <Link to="/Home">
                    Home
                </Link>
                <Link to="/About">
                    Acerca de
                </Link>
                <Link to="/History">
                    Historia
                </Link>
                <Link to="/Shop">
                    Tienda
                </Link>
            </div>
        </nav>
        <div>
            <Outlet />
        </div>
        <div>
            <About />
        </div>
        <div>
            <History />
        </div>
        <div>
            <Shop />
        </div>
        <div>
            <Footer className="footer" />
        </div>
        </>
    )
}