const BaseCard = {
    props:{
        title: String,
        content: {
            type: String,
            default: "",
            description: "card content"
        },
        buttonText: {
            type: String,
            default: "Ok",
            description: "button text"
        },
        srcUrl: {
            type: String,
            default: "images/dooly.jpg",
            description: "image source url"
        }
    },
    template:`
    <div class="card" style="width: 18rem;margin: auto;">
        <img v-bind:src="srcUrl" class="card-img-top" width="100" alt="...">
        <div class="card-body">
            <h5 class="card-title">{{ title }}</h5>
            <p class="card-text">{{ content }}</p>
            <button class="btn btn-primary" @click="handleClick">{{ buttonText}}</button>
        </div>
    </div>
    `
}