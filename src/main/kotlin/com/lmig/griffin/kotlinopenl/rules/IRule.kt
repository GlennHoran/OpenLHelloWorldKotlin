package com.lmig.griffin.kotlinopenl.rules
import com.lmig.griffin.kotlinopenl.model.Case
import com.lmig.griffin.kotlinopenl.model.Response


interface IRule {
    fun helloUser(aCase: Case, response: Response) : String
    }
