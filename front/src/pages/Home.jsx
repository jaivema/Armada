import Navbar from "../layout/Navbar";
import Footer from "../layout/Footer";

import './home.css'

export default function Home (){
    return (
        <>
        <header>
            <Navbar />
        </header>

        <section id="home">
            <h1>Home</h1>
            <article className="premium">
                <p>WE WON THIS YEAR! &gt;&gt;&gt;</p>
                <img src="src/assets/40d6c3a1-node_ICC_2023_Bronze_Medium.png"></img>
            </article>
        </section>
        
        <section id="history">
            <h1>History banner</h1>
        </section>
        
        <section id="products">
            <article className="product">
                <h2>Strawberry</h2>
                <figure>
                <img src="src/assets/StrawberryBottle_S-260x400.png" alt="Strawberry Bottle"/>
                </figure>
                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Tempora, facere adipisci aliquam nesciunt perferendis obcaecati dolor quo? Fugit corrupti, explicabo labore repellat ratione assumenda quo omnis amet, fuga sint ex.</p>
            </article>

            <article className="product">
                <h2>Black Currant</h2>
                <figure>
                <img src="src/assets/BlackCurrantBottle_S-260x400.png" alt="Black currant flavour"/>
                <figcaption>
                    ssssss
                </figcaption>
                </figure>
                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Tempora, facere adipisci aliquam nesciunt perferendis obcaecati dolor quo? Fugit corrupti, explicabo labore repellat ratione assumenda quo omnis amet, fuga sint ex.</p>
            </article>

            <article className="product">
                <h2>Apple</h2>
                <figure>
                <img src="src/assets/AppleBottle_S-260x400.png" alt="Apple flavour"/>
                </figure>
                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Tempora, facere adipisci aliquam nesciunt perferendis obcaecati dolor quo? Fugit corrupti, explicabo labore repellat ratione assumenda quo omnis amet, fuga sint ex.</p>
            </article>
        </section>
        
        <footer>
            <Footer />
        </footer>
        </>
    )
}