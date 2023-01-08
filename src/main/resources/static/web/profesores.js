
const app = Vue.
createApp({
    data() {
        return {
          cursos:[],
          borrarProfesor:"", 
          profesores:[],  
        }
    },
    
    created() {
      axios.get('/api/profesor')
      .then( response =>{
        this.profesores = response.data;
        console.log(this.profesores)
      })
      .catch(function(error){console.log(error)})  
    },  

    methods: {         
        borrarProfe(){
            axios.delete('/api/profesor',`nombreProfesor=${this.borrarProfesor}`)
            .then(x=> window.location.reload()) 
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