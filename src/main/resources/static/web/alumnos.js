
const app = Vue.
  createApp({
    data() {
      return {
        cursos: [],
        nombre: "",
        edad: 0,
        fechaNacimiento: "",
        historia: "",
        alumnos: [],
        nombreBorrar: "",
        profesores:[],
      }
    },

    created() {
      axios.get('/api/alumno')
        .then(response => {
          this.alumnos = response.data;
          console.log(this.alumnos)
        })
        .catch(function (error) { console.log(error) })
    
    axios.get('/api/profesor')
    .then(response => {
      this.profesores = response.data;
      console.log(this.profesores)
    })
    .catch(function (error) { console.log(error) })

    
},
    methods: {
      inscripcion() {
        Swal.fire({
          title: '¿Seguro quieres inscribirte en este Curso?',
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Si, inscribirme!'
        })
          .then((result) => {
            if (result.isConfirmed) {
              axios.post('/api/alumno/registrarAlumno',
                "nombre=" + this.nombre + "&edad=" + this.edad + "&fechaNacimiento=" + this.fechaNacimiento + "&historia=" + this.historia)
                .then(
                  Swal.fire(
                    'Inscripto!',
                    'Has sido inscripto con éxito!',
                    'success')
                    .then(response => window.location.reload())
                )
            }
          })
      },

      borrarAlumno() {
        axios.delete('/api/alumno', `nombre=${this.nombreBorrar}`)
          .then(x => window.location.reload())
          .catch(response => Swal.fire({
            icon: 'error',
            title: 'Oops..!',
            text: 'Algún dato es incorrecto!',
          }))
      }
    }
  }
  )

  .mount('#app');