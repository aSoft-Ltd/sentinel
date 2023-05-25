package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `kotlinx` extension.
*/
@NonNullApi
public class LibrariesForKotlinx extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final CoroutinesLibraryAccessors laccForCoroutinesLibraryAccessors = new CoroutinesLibraryAccessors(owner);
    private final SerializationLibraryAccessors laccForSerializationLibraryAccessors = new SerializationLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForKotlinx(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for atomicfu (org.jetbrains.kotlinx:atomicfu)
         * This dependency was declared in catalog kotlinx.toml
         */
        public Provider<MinimalExternalModuleDependency> getAtomicfu() { return create("atomicfu"); }

        /**
         * Creates a dependency provider for cli (org.jetbrains.kotlinx:kotlinx-cli)
         * This dependency was declared in catalog kotlinx.toml
         */
        public Provider<MinimalExternalModuleDependency> getCli() { return create("cli"); }

        /**
         * Creates a dependency provider for datetime (org.jetbrains.kotlinx:kotlinx-datetime)
         * This dependency was declared in catalog kotlinx.toml
         */
        public Provider<MinimalExternalModuleDependency> getDatetime() { return create("datetime"); }

    /**
     * Returns the group of libraries at coroutines
     */
    public CoroutinesLibraryAccessors getCoroutines() { return laccForCoroutinesLibraryAccessors; }

    /**
     * Returns the group of libraries at serialization
     */
    public SerializationLibraryAccessors getSerialization() { return laccForSerializationLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class CoroutinesLibraryAccessors extends SubDependencyFactory {

        public CoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (org.jetbrains.kotlinx:kotlinx-coroutines-android)
             * This dependency was declared in catalog kotlinx.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() { return create("coroutines.android"); }

            /**
             * Creates a dependency provider for core (org.jetbrains.kotlinx:kotlinx-coroutines-core)
             * This dependency was declared in catalog kotlinx.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("coroutines.core"); }

            /**
             * Creates a dependency provider for test (org.jetbrains.kotlinx:kotlinx-coroutines-test)
             * This dependency was declared in catalog kotlinx.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() { return create("coroutines.test"); }

    }

    public static class SerializationLibraryAccessors extends SubDependencyFactory {
        private final SerializationTomlLibraryAccessors laccForSerializationTomlLibraryAccessors = new SerializationTomlLibraryAccessors(owner);

        public SerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.jetbrains.kotlinx:kotlinx-serialization-core)
             * This dependency was declared in catalog kotlinx.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("serialization.core"); }

            /**
             * Creates a dependency provider for json (org.jetbrains.kotlinx:kotlinx-serialization-json)
             * This dependency was declared in catalog kotlinx.toml
             */
            public Provider<MinimalExternalModuleDependency> getJson() { return create("serialization.json"); }

            /**
             * Creates a dependency provider for yaml (net.mamoe.yamlkt:yamlkt)
             * This dependency was declared in catalog kotlinx.toml
             */
            public Provider<MinimalExternalModuleDependency> getYaml() { return create("serialization.yaml"); }

        /**
         * Returns the group of libraries at serialization.toml
         */
        public SerializationTomlLibraryAccessors getToml() { return laccForSerializationTomlLibraryAccessors; }

    }

    public static class SerializationTomlLibraryAccessors extends SubDependencyFactory {

        public SerializationTomlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (com.akuleshov7:ktoml-core)
             * This dependency was declared in catalog kotlinx.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("serialization.toml.core"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: atomicfu (0.20.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog kotlinx.toml
             */
            public Provider<String> getAtomicfu() { return getVersion("atomicfu"); }

            /**
             * Returns the version associated to this alias: cli (0.3.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog kotlinx.toml
             */
            public Provider<String> getCli() { return getVersion("cli"); }

            /**
             * Returns the version associated to this alias: coroutines (1.7.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog kotlinx.toml
             */
            public Provider<String> getCoroutines() { return getVersion("coroutines"); }

            /**
             * Returns the version associated to this alias: datetime (0.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog kotlinx.toml
             */
            public Provider<String> getDatetime() { return getVersion("datetime"); }

            /**
             * Returns the version associated to this alias: ktoml (0.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog kotlinx.toml
             */
            public Provider<String> getKtoml() { return getVersion("ktoml"); }

            /**
             * Returns the version associated to this alias: serialization (1.5.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog kotlinx.toml
             */
            public Provider<String> getSerialization() { return getVersion("serialization"); }

            /**
             * Returns the version associated to this alias: yaml (0.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog kotlinx.toml
             */
            public Provider<String> getYaml() { return getVersion("yaml"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
