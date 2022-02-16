<template>
    <div class="rootDiv">
        <form>
            <label>Email: </label>
            <input type="email" required v-model="email"> <!--v-model binds the input to the variable within data()-->

            <label>Password: </label>
            <input type="password" required v-model="password">

            <label>Role: </label>
            <select v-model="role">
                <option value="developer">Web developer</option>
                <option value="designer">Web designer</option>
            </select>

            <label>Skills:</label>
            <input type="text" v-model="tempSkill" @keyup="addSkill">
            <div v-for="skill in skills" :key="skill" class="pill" @click="removeSkill(skill)">
                {{ skill }}
            </div>

            <div class="terms">
                <input type="checkbox" v-model="terms" required>
                <label>Accept terms and conditions</label>
            </div>

            <div class="submit">
                <button>Create account</button>
            </div>

        </form>

        <p> Email: {{ email }} </p>
        <p> Password: {{ password }} </p>
        <p> Role: {{ role }} </p>
        <p> Terms accepted: {{ terms }} </p>
    </div>
</template>

<script>
export default {
    data() {
        return {
            email: '',
            password: '',
            role: '',
            terms: false,
            tempSkill: '',
            skills: []
        }
    },
    methods: {
        addSkill(e) {
            if (e.key === ',' && this.tempSkill) {
                this.tempSkill = this.tempSkill.slice(0, -1)
                if (!this.skills.includes(this.tempSkill)) {
                    this.skills.push(this.tempSkill)
                }
                this.tempSkill = ""
            }
        },
        removeSkill(skill) {
            this.skills.splice(this.skills.indexOf(skill), 1)
        }
    }
}
</script>

<style scoped>
    form{
        max-width: 420px;
        margin: 30px auto;
        background: white;
        text-align: left;
        padding: 40px;
        border-radius: 10px;
    }
    label {
        color: #aaa;
        display: inline-block;
        margin: 25px 0 15px;
        font-size: 0.6em;
        text-transform: uppercase;
        letter-spacing: 1px;
        font-weight: bold;
    }
    input, select {
        display: block;
        padding: 10px 6px;
        width: 100%;
        box-sizing: border-box;
        border: none;
        border-bottom: 1px solid #ddd;
        color: #555;
    }
    input[type="checkbox"] {
        display: inline-block;
        width: 16px;
        margin: 0 10px 0 0;
        position: relative;
        top: 2px;
    }
    .pill {
        display: inline-block;
        margin: 20px 10px 0 0;
        padding: 6px 12px;
        background: #eee;
        border-radius: 20px;
        font-size: 12px;
        letter-spacing: 1px;
        font-weight: bold;
        color: #777;
        cursor: pointer;
    }
    button {
        background: #0b6dff;
        border: 0;
        padding: 10px 20px;
        margin-top: 20px;
        color: white;
        border-radius: 20px;
        cursor: pointer;
    }
    .sumbit {
        text-align: center;
    }
    .rootDiv {
        background-color: rgb(221, 221, 221);
    }
</style>