job('EjecucionRemotaScript1'){
  description('Job DSL que ejecuta el script prueba.sh de github')
  scm{
    git('https://github.com/jacfpentester/jenkinsscript.git', 'master'){
      node ->
        node / gitConfigName('jacfpentester')
        node / gitConfigEmail('jacfpentester@gmail.com')
    }
  }
  parameters{
    choiceParam('opciones',['Opcion 1', 'Opcion2', 'Opcion3 (default)'] )
  }
  triggers {
    cron('H/1 * * * *')
  }
  steps {
    shell("cat hola.txt")
  }
  publishers {
    mailer('jacfpentester@gmail.com',true,true)
  }
}
