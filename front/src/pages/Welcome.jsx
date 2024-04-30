import "./Welcome.css"

export default function Welcome (){

    return (
      <>
        <div className="background-welcome" >
          <h1>TO VISIT THE PAGE YOU NEED TO VERIFY YOUR AGEº</h1>
          <h3>Areyou over 18 years of age?</h3>
          <button>Yes</button>
          <button>No</button>
        </div>
        <div>
          <img src="src/assets/logo_armada_sider.png"/>
        </div>
      </>
    );
}
