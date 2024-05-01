import './About.css'

export default function About (){

  return (
    <>
      <main className="background-main">
        <section id="products">
          <h1>Acerca de nuestros productos</h1>
          
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
      </main>
    </>
  );
}