
import Webcam from 'react-webcam'
import './App.css'
import { BarraLateral } from './components/BarraLateral'
import { useCallback, useRef, useState } from 'react';
import axios from 'axios';
import { Outlet } from 'react-router-dom';

export default function App() {

  return (
    <div className="flex">

      <BarraLateral />

      <main className="">
        <Outlet />
      </main>

    </div>
  )

}



//   type Localizacao = {
//   latitude: number;
//   longitude: number;
// };


  // const [localizacao, setLocalizacao] = useState<Localizacao | null>(null);
  // const [cameraLigada, setCameraLigada] = useState<boolean>(false)

  // const webcamRef = useRef(null);
  // const [imgSrc, setImgSrc] = useState(null);

  // const capture = useCallback(() => {
  //   const imageSrc = webcamRef.current.getScreenshot();
  //   setImgSrc(imageSrc);
  // }, [webcamRef]);

  // function ponto () {
  //   if (navigator.geolocation) {
  //     navigator.geolocation.getCurrentPosition(
  //       (position) => {
  //         setLocalizacao({
  //           latitude: position.coords.latitude,
  //           longitude: position.coords.longitude,
  //         });
  //       },
  //       (error) => {
  //         console.warn(`Erro ao obter localização: ${error.message}`);
  //       }
  //     )
  //     console.log(localizacao)
  //   }
  // }

  // async function enviarPonto () {

  //   var body = {
  //     "idFuncionario" : 1,
  //     "latitude": localizacao?.latitude,
  //     "longitude": localizacao?.longitude,
  //     "foto" : ""
  //   }
    
  //   if (imgSrc) {
  //     console
  //     console.log(imgSrc)
  //     body.foto = imgSrc
  //   }

    
  //   const response = await axios({
  //     method: "post",
  //     url: "http://localhost:8080/api/ponto/baterPonto",
  //     data: body,
  //     headers: {
  //       'Content-Type' : 'application/json'
  //     }
  //   })

  //   console.log(response.status)
  // }

  // return (
  //   <>
  //   <BarraLateral/>
  //   {cameraLigada ? <Webcam ref={webcamRef} height={600} width={600}></Webcam> : <div><h1>Camera desligada</h1></div>}
  //   <div className="btn-container">
  //       <button onClick={capture}>Capture photo</button>
  //   </div>
  //   {imgSrc ? <img src={imgSrc}></img> : <h1 className="font-bold">Sem foto</h1>}
  //   <button onClick={() => setCameraLigada(!cameraLigada)}>Ligar Câmera</button>
  //   <button onClick={enviarPonto}>Enviar Ponto OFC </button>
  // </>
  // )