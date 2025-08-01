<template>
    <div>
        <h2>Aktuelle Issues:</h2> 
        <button @click='loadIssues'>Aktualisieren</button>
        <ul>
            <li v-for=" issue in issues" :key="issue.id">
                <strong>{{ issue.title }}</strong>
                <p>{{ issue.description }}</p>
            </li>   
        </ul>
    </div>
</template>

<script setup lang="ts">
    import { ref, onMounted } from 'vue';
    const issues = ref<any>([]);

    async function loadIssues(){
        const response = await fetch('http://localhost:8080/api/issues')
        issues.value = await response.json()
    }
    
    onMounted(async() =>{
        loadIssues()
    });

</script>

<style scoped>
</style>
