import "./Welcome.css"

export default function Welcome (){

    return (
      <>
      <main>
        <section className="background-welcome">
          <article>
            <figure>
              <img src="src/assets/logo_armada_sider.png"/>
            </figure>
            <figcaption>
              <h1>TO VISIT THE PAGE YOU NEED TO VERIFY YOUR AGE</h1>
              <h3>Are you over 18 years of age?</h3>
              <button>Yes</button>
              <button>No</button>
            </figcaption>
          </article>
        </section>
      </main>
      </>
    );
}
