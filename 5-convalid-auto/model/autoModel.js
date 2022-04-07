function AutoModel() {
    this.autos = [];

     this.initialise = () => {
        if(localStorage.getItem('autos') != null) { 
            this.autos = JSON.parse(localStorage.getItem('autos'));
        }
        console.log(this.autos);
    }

    this.push = (auto) => {
        
        this.autos.push(auto);
        localStorage.setItem("autos", JSON.stringify(this.autos));
    }
    
    this.clean = () => {
        this.autos = [];
        localStorage.setItem("autos", JSON.stringify(this.autos));
    }

    this.remove = (index) => {
        this.autos.splice(index, 1);
        localStorage.setItem("autos", JSON.stringify(this.autos));
    }
}
