package com.lmig.griffin.kotlinopenl.rules

import org.openl.rules.runtime.RulesEngineFactory
import org.openl.runtime.EngineFactory
import com.lmig.griffin.kotlinopenl.model.Case
import com.lmig.griffin.kotlinopenl.model.Response
import com.lmig.griffin.kotlinopenl.model.User
import java.lang.reflect.Method
import java.util.*


class Main {


    fun callRulesWithGeneratedInterface() {
        val engineFactory: EngineFactory<IRule> = RulesEngineFactory("/Users/n0326266/Documents/Sandbox/Griffin/KotlinOpenL/src/main/resources/openltablets/HelloUser1.xls")

        val calendar: Calendar = Calendar.getInstance()
        val hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
        val rulesFactory = engineFactory.interfaceClass
        val user = User("Glenn")
        val aCase = Case(user, hour)
        try {
            val method: Method = rulesFactory.getMethod("helloUser", Int.javaClass)
            println("Executing OpenL Rules")
            method.invoke(aCase, "")
        } catch (e: NoSuchMethodException) {
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val rules = Main()
            rules.callRulesWithGeneratedInterface()
        }
    }
}


//class Main {
//    private var instance: IRule? = null
//
//    fun process(aCase: Case, response: Response) {
//        val engineFactory :EngineFactory<IRule> = RulesEngineFactory(javaClass.classLoader
//                .getResource("openltablets/HelloUser1.xls"), IRule::class.java)
//        instance = engineFactory.newEngineInstance()
//        instance!!.helloUser(aCase, response)
//    }
//
//    companion object {
//
//        @JvmStatic
//        fun main(args: Array<String>) {
//            val rules = Main()
//            val user = User("Glenn")
//            val aCase = Case(user, 12)
//            val response = Response("")
//            rules.process(aCase, response)
//        }
//    }
//}









//class Main() {
//
//    val engineFactory : EngineFactory<IRule> = RulesEngineFactory<IRule>(javaClass.classLoader.getResource("openltablets/HelloUser.xls"))
//    val instance = engineFactory.newEngineInstance()
//
//
//    fun main(args: Array<String>) {
//        val rules = Main()
//        val user = User("Donald Duck")
//        val aCase = Case(user, 12)
//        rules.process(aCase)
//    }
//
//    fun process(case: Case) {
//        instance.helloUser(case, Response())
//    }
//}


