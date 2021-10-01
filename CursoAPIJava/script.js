let tituloNota = document.getElementById("nota-titulo");

let usuarioUsername = "camilo123";
let userId = 1;

let contenidoNota = document.getElementById("nota-contenido");

let guardarNotaBtn = document.getElementById("guardar-nota");

let formularioNota = document.getElementById("formulario-nota");

let notasContenedor = document.getElementById("notas-container");

let notaTemplate = (notaTitulo, notaFecha, notaContenido) =>{
    return `
    <div class="nota">
        <div class="nota-top">
        <div>
            <span class="notahecha-titulo">${notaTitulo}</span>
            <span class="notahecha-fecha">${notaFecha}</span>
        </div>
        <div>
            <button class="borrar-nota-btn">
            <i class="fas fa-trash"></i>
            </button>
        </div>
        </div>
        <div class="nota-bottom">
        <p class="notahecha-contenido">
            ${notaContenido}
        </p>
        </div>
    </div>
    `
}


formularioNota.addEventListener("submit", (e)=>{
    guardarNota()
    reiniciarNota();
    e.preventDefault();
})

let reiniciarNota =()=>{
    tituloNota.value = "";
    contenidoNota.value = "";
}

let listarNotas = () =>{
    fetch(`http://localhost:8080/nota/byUser/${usuarioUsername}`)
    .then(response => response.json())
    .then(response => {
        for(let i in response){
            let nota = response[i];
            let fecha = new Date(nota.fecha);
            notasContenedor.innerHTML += notaTemplate(nota.titulo, fecha, nota.contenido);
        }
    });
}

let guardarNota = () =>{

    let nt = tituloNota.value;
    let nc = contenidoNota.value;
    let fecha = new Date().getTime();

    fetch(`http://localhost:8080/nota/create`,{
        method: "POST",
        headers: {
            'Accept': 'application/json, text/plain',
            'Content-Type': 'application/json;charset=UTF-8'
        },
        body: JSON.stringify({
            "titulo": nt,
            "contenido": nc,
            "fecha": fecha,
            "userId": userId
        })
    })
    .then(response => response.json())
    .then(response => {
        console.log("llega")
        console.log(response)
        notasContenedor.innerHTML += notaTemplate(nt, fecha, nc);
    });
}

listarNotas();