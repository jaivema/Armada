import Navbar from "../layout/Navbar";
export default function Shop(){
    
    return  (
        <>
        <header>
            <Navbar />
        </header>
        <h1>Shop main</h1>
        <section>
            <ul>
                <li>
                    <h3>Producto</h3>
                </li>
                <li>
                    <p>Descripción</p>
                </li>
                <li>
                    <p>precio</p>
                </li>
            </ul>
        </section>
        </>
    );
}