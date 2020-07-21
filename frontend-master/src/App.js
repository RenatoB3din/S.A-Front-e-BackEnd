import React from 'react';
import './global.css';

// import { uniqueId } from 'lodash';
// import filesize from 'filesize';


import Routes from './routes';


//     this.setState({
//       uploadedFiles: response.data.map(file => ({
//         id: file._id,
//         name: file.name,
//         readableSize: filesize(file.size),
//         preview: file.url,
//         uploaded: true,
//         url: file.url,
//       }))
//     })
//   }

//   handleUpload = files => {
//     const uploadedFiles = files.map(file => ({
//       file,
//       id: uniqueId(),
//       name: file.name,
//       readableSize: filesize(file.size),
//       preview: URL.createObjectURL(file),
//       progress: 0,
//       uploaded: false,
//       error: false,
//       url: null,
//     }))



function App() {
  return(
    <Routes />
  );
}

export default App;
