import './Layout.css'
import Home     from '../pages/Home.jsx'
import About    from '../pages/About.jsx'
import History  from '../pages/History.jsx'
import Shop     from '../pages/Shop.jsx'
import Footer   from './Footer.jsx'
import {Outlet, Link} from "react-router-dom"

export default function Layout (){
    return (
        <>
        <header>
            <nav>
                <Link to ="/">
                    <div className="logo">
                        <img src="src/assets/LOGO_ARMADA_324x205.png" alt="Armada Cider 1588"/>
                    </div>
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
        </header>
        <body>
            <Outlet />
            <Home />
            <About />
            <History />
            <Shop />
            <Footer className="footer" />
        </body>
        </>
    )
}