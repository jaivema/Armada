import Footer from './Footer.jsx'
import Header from "./Header.jsx";
import {Outlet, Link} from "react-router-dom";

export default function Layout (){
    return (
        <>
        <nav>
            <div>
                <Link to ="/">
                    Home
                </Link>
                <Link to="/History">
                    History
                </Link>
                <Link to="/Shop">
                    Shop
                </Link>
            </div>
        </nav>
        <div>
            <Header/>
        </div>
        <div>
            <Outlet />
        </div>
        <div>
            <Footer />
        </div>
        </>

    )
}