import Navbar from "../layout/Navbar";

export default function History(){

    return  (
        <>
        <main>
            <header>
                <Navbar />
            </header>
            <h1>History main</h1>
            <article>
                <ul>
                    <li style={{display: 'inline-block', margin: '5px'}}>
                        <p>párrafo</p>
                    </li>
                    <li style={{display: 'inline-block', margin: '5px'}}>
                        <p>foto</p>
                    </li>
                </ul>
            </article>

            <article>
                <ul>
                    <li style={{display: 'inline-block', margin: '5px'}}>
                        <p>foto</p>
                    </li>
                    <li style={{display: 'inline-block', margin: '5px'}}>
                        <p>párrafo</p>
                    </li>
                </ul>
            </article>
        </main>
        </>
    );
}