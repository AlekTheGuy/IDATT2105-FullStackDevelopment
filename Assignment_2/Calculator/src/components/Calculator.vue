<template>
    <div class="calculator">
        <h1 class="inputfield">{{currentCalculation}}</h1>
        <div class="buttons">
            <button class="button" v-for="n in buttonArray" :key="n" @click="processInput(n)">{{n}}</button>
        </div>
    </div>
</template>

<script>
export default {
    data: function() {
        return {
            buttonArray: ["7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"],
            currentCalculation: "ready",
            toClear: true,
        }
    },
    methods: {
        processInput(n) {
            if (this.toClear == true) {
                this.currentCalculation = "";
                this.toClear = false;
            }
            if (n == "=") {
                //Never use eval() unless you´re an absolute moron like me, shits dangeorus yo.
                let answer = eval(this.currentCalculation);
                this.currentCalculation = answer;
                this.toClear = true;
            } else {
                this.currentCalculation += n; 
            }
        }
    }
}
</script>

<style scoped>
.calculator{
    display: grid;
    grid-template-areas:
    'inputfield'
    'buttons'
    'history';
    width: 270px;
    max-width: 270px;
    height: 360px;
    background-color: rgb(112, 112, 112);
}

.buttons{
    display: grid;
    grid-template-areas:
    'button button button button'
    'button button button button'
    'button button button button'
    'button button button button';
    grid-gap: 5px;
    margin: auto;
    margin-bottom: 0px;
}

.button{
    height: 60px;
    max-height: 60px;
    max-width: 60px;
    width: 60px;
    font-size: 20px;
    font-weight: bold;
}

.inputfield {
    background-color: rgb(192, 190, 190);
    max-width: 250px;
    width: 250px;
    margin: auto;
}

</style>